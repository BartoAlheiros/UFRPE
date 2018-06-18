package main;

public class enumPrincipal {

	public static void main(String[] args) {
		MarcasEnum amazon = MarcasEnum.AMAZON;
		MarcasEnum hp = MarcasEnum.HP;  
		MarcasEnum samsung = MarcasEnum.SAMSUNG;
		
		
		
		System.out.println("Nome da Marca = "+amazon.name()+", "+amazon.ordinal());
		System.out.println("Nome da Marca = "+hp.name()+", "+hp.ordinal());
		System.out.println("Nome da Marca = "+samsung.name()+", "+samsung.ordinal());
	}

}
