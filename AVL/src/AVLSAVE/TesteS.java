package AVLSAVE;

public class TesteS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArvoreAvl tree = new ArvoreAvl();
		tree.inserir(8);
		tree.inserir(5);
		tree.inserir(7);
		tree.inserir(4);
		tree.inorder(tree.raiz);
		tree.preOrder(tree.raiz);
	}

}
