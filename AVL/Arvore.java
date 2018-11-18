package AVL;


public class Arvore{
	 private No raiz;
	
	 public No getRaiz() {
		 return this.raiz;
	 }

	public void inserir(int k) {
		No n = new No(k);
		inserirAVL(this.raiz, n);
	}

	private void inserirAVL(No antigo, No novo) {

		if (antigo == null) {
			this.raiz = novo;

		} else {

			if (novo.getChave() < antigo.getChave()) {

				if (antigo.getEsquerda() == null) {
					antigo.setEsquerda(novo);
					novo.setPai(antigo);
					verificarBalanceamento(antigo);

				} else {
					inserirAVL(antigo.getEsquerda(), novo);
				}

			} else if (novo.getChave() > antigo.getChave()){
						

				if (antigo.getDireita() == null) {
					antigo.setDireita(novo);
					novo.setPai(antigo);
					verificarBalanceamento(antigo);

				} else {
					inserirAVL(antigo.getDireita(), novo);
				}

			}
		}
	}

	private void verificarBalanceamento(No node) {
		setBalanceamento(node);
		int balanceamento = node.getBalanceamento();

		if (balanceamento == -2) {

			if (altura(node.getEsquerda().getEsquerda()) >= altura(node.getEsquerda().getDireita())) {
				node = rotacaoDireita(node);

			} else {
				node = duplaRotacaoEsquerdaDireita(node);
			}

		} else if (balanceamento == 2) {

			if (altura(node.getDireita().getDireita()) >= altura(node.getDireita().getEsquerda())) {
				node = rotacaoEsquerda(node);

			} else {
				node = duplaRotacaoDireitaEsquerda(node);
			}
		}

		if (node.getPai() != null) {
			verificarBalanceamento(node.getPai());
		} else {
			this.raiz = node;
		}
	}

	public void remover(int k) {
		removerAVL(this.raiz, k);
	}

	private void removerAVL(No node, int k) {
		if (node == null) {
			return;

		} else {

			if (node.getChave() > k) {
				removerAVL(node.getEsquerda(), k);

			} else if (node.getChave() < k) {
				removerAVL(node.getDireita(), k);

			} else if (node.getChave() == k) {
				removerNoEncontrado(node);
			}
		}
	}

	private void removerNoEncontrado(No aRemover) {
		No r;

		if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {

			if (aRemover.getPai() == null) {
				this.raiz = null;
				aRemover = null;
				return;
			}
			r = aRemover;

		} else {
			r = sucessor(aRemover);
			aRemover.setChave(r.getChave());
		}

		No p;
		if (r.getEsquerda() != null) {
			p = r.getEsquerda();
		} else {
			p = r.getDireita();
		}

		if (p != null) {
			p.setPai(r.getPai());
		}

		if (r.getPai() == null) {
			this.raiz = p;
		} else {
			if (r == r.getPai().getEsquerda()) {
				r.getPai().setEsquerda(p);
			} else {
				r.getPai().setDireita(p);
			}
			verificarBalanceamento(r.getPai());
		}
		r = null;
	}

	private No rotacaoEsquerda(No inicial) {

		No direita = inicial.getDireita();
		direita.setPai(inicial.getPai());

		inicial.setDireita(direita.getEsquerda());

		if (inicial.getDireita() != null) {
			inicial.getDireita().setPai(inicial);
		}

		direita.setEsquerda(inicial);
		inicial.setPai(direita);

		if (direita.getPai() != null) {

			if (direita.getPai().getDireita() == inicial) {
				direita.getPai().setDireita(direita);
			
			} else if (direita.getPai().getEsquerda() == inicial) {
				direita.getPai().setEsquerda(direita);
			}
		}

		setBalanceamento(inicial);
		setBalanceamento(direita);

		return direita;
	}

	private No rotacaoDireita(No inicial) {

		No esquerda = inicial.getEsquerda();
		esquerda.setPai(inicial.getPai());

		inicial.setEsquerda(esquerda.getDireita());

		if (inicial.getEsquerda() != null) {
			inicial.getEsquerda().setPai(inicial);
		}

		esquerda.setDireita(inicial);
		inicial.setPai(esquerda);

		if (esquerda.getPai() != null) {

			if (esquerda.getPai().getDireita() == inicial) {
				esquerda.getPai().setDireita(esquerda);
			
			} else if (esquerda.getPai().getEsquerda() == inicial) {
				esquerda.getPai().setEsquerda(esquerda);
			}
		}

		setBalanceamento(inicial);
		setBalanceamento(esquerda);

		return esquerda;
	}

	private No duplaRotacaoEsquerdaDireita(No inicial) {
		inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
		return rotacaoDireita(inicial);
	}

	private No duplaRotacaoDireitaEsquerda(No inicial) {
		inicial.setDireita(rotacaoDireita(inicial.getDireita()));
		return rotacaoEsquerda(inicial);
	}

	private No sucessor(No q) {
		if (q.getDireita() != null) {
			No r = q.getDireita();
			while (r.getEsquerda() != null) {
				r = r.getEsquerda();
			}
			return r;
		} else {
			No p = q.getPai();
			while (p != null && q == p.getDireita()) {
				q = p;
				p = q.getPai();
			}
			return p;
		}
	}

	private int altura(No node) {
		if (node == null) {
			return -1;
		}

		if (node.getEsquerda() == null && node.getDireita() == null) {
			return 0;
		
		} else if (node.getEsquerda() == null) {
			return 1 + altura(node.getDireita());
		
		} else if (node.getDireita() == null) {
			return 1 + altura(node.getEsquerda());
		
		} else {
			return 1 + Math.max(altura(node.getEsquerda()), altura(node.getDireita()));
		}
	}

	private void setBalanceamento(No no) {
		no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
}


	 	
	    public String toString(){
	        return "["+raiz.getChave()+"] ("+raiz.getBalanceamento()+")";
	    }

	    public void inorder(No no) {
			if (no == null) {
				return;
			}
			inorder(no.getEsquerda());
			System.out.println("["+no.getChave()+"]" + " bal "+no.getBalanceamento() );
			inorder(no.getDireita());
	    }

	    public void posorder(No no) {
	    	if(no!=null) {
	    		posorder(no.getEsquerda());
	    		posorder(no.getDireita());
	    		System.out.println("["+no.getChave()+"]" + " bal "+no.getBalanceamento() );
	    	}
	    }

	    public void preOrder(No no) {
	    	if(no!=null) {
	    		System.out.println("["+no.getChave()+"]" + "--> bal ="+no.getBalanceamento() );
	    		preOrder(no.getEsquerda());
	    		preOrder(no.getDireita());
	    	}
	    }















}