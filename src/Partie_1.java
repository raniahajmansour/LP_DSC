import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Partie_1 {
	int M; // Nombre N de capteurs
	int ran;
	int N; // Nombre M de zones a surveiller 
	float T[] = new float[100]; // duree de vie de chaque capteur separee par un espace
	int Z[][] = new int[100][100]; // numero de zones couvertes par le capteurs
	int delta[][] = new int[100][100];
	
	
	public void Read_Data(String fichier)
	{
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			ligne = br.readLine();
			N = Integer.parseInt(ligne);
			//System.out.println("N = " + N);
					
			ligne = br.readLine();
			M = Integer.parseInt(ligne);
		   // System.out.println("M = " + M);
					
		    ligne = br.readLine();
			String[] parts = ligne.split(" ");
			for(int i =0; i < N; i++)
			{
				T[i] =  Float.parseFloat(parts[i]);
				//System.out.print(T[i] + " ");
			}
					
			//System.out.println("");
					
			for(int i = 0; i< N; i++)
			{
				ligne =br.readLine();
				parts = ligne.split(" ");
				for(int j = 0; j < M; j++)
				{
					if (j < parts.length)
					{
						Z[i][j] =  Integer.parseInt(parts[j]);
						//System.out.print(Z[i][j] + " ");
					}
					else
					{
						Z[i][j] = 0;
						//System.out.print(Z[i][j] + " ");
					}
							
				}
				//System.out.println("");
			}
			
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}	
		
	}
	
	public void Print_Data()
	{
		System.out.println("Nombre de capteurs N = " + N);
		System.out.println("Nombre de zones M = " + M);
		System.out.print("Durée de vie de chaque capteur: ");
		for(int i =0; i < N; i++)
		{
			System.out.print("C"+(i+1)+"="+T[i] + " ");
	    }
					
		System.out.println("");
		System.out.println("Les zones de couvertures de chaque capteurs: ");
		for(int i = 0; i< N; i++)
		{System.out.print("C"+(i+1)+":");
			for(int j = 0; j<M; j++)
			{if(Z[i][j]!=0) {
				System.out.print("Z"+Z[i][j] +" ");
			}
			}
			System.out.println("");
		}	
	}
	public void Calculer_delta()
	{
	    //Role:
	    //A partir de les diffrentes distances d'un capteur particulier on peut construire une ligne de delta.
	    //Retourne la matrice "delta" .
	    //Les lignes de la matrice presente les capteurs.
	    //les colonnes de la matrice presente les targets.
	    //losqu'on met par exemple 1 dans la case(1,1)  c'est_a_dire le capteur un couvre la target 1 .

	    int i,k,j,test;

	    for(i=0;i<N;i++)
	    {
	        for(j=0;j<M;j++)
	        {

	            delta[i][j]=0;
	        }

	    }

	for(i=0;i<N;i++)
	    {
	     for(k=0;k<M;k++)
	    {
	        if(Z[i][k]!=0) {delta[i][Z[i][k]-1]=1;}

	    }
	    }
	System.out.println("Delta: ");
	    for(i=0;i<N;i++)
	    {
	        for(j=0;j<M;j++)
	        	System.out.print(delta[i][j] +" ");
			System.out.println("");
	    }
	}
	

}
