package AVL;

public class Testew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arvore tree = new Arvore();
		
		/*tree.inserir(8);
		
		tree.inserir(5);

		tree.inserir(7);*/
		
		//tree.inorder(tree.raiz);
		//System.out.println("");
		
		//tree.inserir(4);
		//tree.inserir(12);
		
		
	
		
		//System.out.println(tree.printArvore(0,tree.raiz));
		//tree.inorder(tree.raiz);
		//System.out.println(tree.printArvore(0, tree.raiz));
		/*System.out.println("--------------------------");
		System.out.println(" ");
		System.out.println(" ");*/
		//System.out.println(tree.printArvore(0,tree.raiz));
		
		tree.inserir(8);
		tree.inserir(5);
		tree.inserir(7);
		tree.inserir(4);
		tree.inserir(12);
		tree.inserir(14);
		tree.inserir(10);
		tree.inserir(9);
		tree.inserir(3);
		tree.inserir(6);
		tree.inserir(11);
		tree.inserir(13);
		tree.preOrder(tree.getRaiz());
		
		/*System.out.println("----------------------------------");
		System.out.println("--------Removendo o 4-------------");
		tree.remover(4);*/
		
		//tree.preOrder(tree.getRaiz());
		System.out.println("----------------------------------");
		System.out.println("--------Removendo o 13------------");
		tree.remover(13);
		//tree.preOrder(tree.getRaiz());
		System.out.println("----------------------------------");
		System.out.println("--------Removendo o 3------------");
		tree.remover(3);
		//tree.preOrder(tree.getRaiz());
		System.out.println("----------------------------------");
		System.out.println("--------Removendo o 5------------");
		tree.remover(5);
		//tree.preOrder(tree.getRaiz());
		System.out.println("----------------------------------");
		System.out.println("--------Removendo o 6------------");
		tree.remover(6);
		tree.preOrder(tree.getRaiz());
		System.out.println("----------------------------------");
		System.out.println("--------------AVL-----------------");
		Arvore tree2 = new Arvore();
		
		
		
		tree2.inserir(50);
		tree2.inserir(10);
		tree2.inserir(80);
		tree2.inserir(20);
		tree2.inserir(5);
		tree2.inserir(70);
		tree2.inserir(90);
		tree2.inserir(4);
		tree2.inserir(60);
		tree2.inserir(100);
		tree2.inserir(75);
		tree2.inserir(65);
		tree2.preOrder(tree2.getRaiz());
		
		tree2.remover(50);
		System.out.println("-----------------------");
		tree2.preOrder(tree2.getRaiz());
		/*tree.remover(7);
		System.out.println("------------------------------");
		tree.inorder(tree.raiz);
		System.out.println("---------------------");
		tree.remover(4);
		tree.inorder(tree.raiz);*/
		//{8, 5, 7, 4, 12, 14, 10, 9, 3, 6, 11, 13}
		
	}

}
