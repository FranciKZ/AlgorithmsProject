import java.util.*;

class Main{
	// main class to build the gui and such in
	public static void main(String[] args){

		String start = "";
		Double distance = 0.0;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a node to start at: ");
		start = input.nextLine();
		System.out.println("Enter a distance to run: ");
		distance = input.nextDouble();   	

		if (distance == 0) {
			System.out.println("Distance must be greater than 0");
			System.out.println("Enter a distance to run: ");
			distance = input.nextDouble();  
		}
		Vertex startVert;


		algoGraph g = new algoGraph();
		Vertex A = new Vertex(1, "A");
		Vertex B = new Vertex(2, "B");
		Vertex C = new Vertex(3, "C");
		Vertex D = new Vertex(4, "D");
		Vertex E = new Vertex(5, "E");
		Vertex G = new Vertex(6, "G");
		Vertex H = new Vertex(7, "H");
		Vertex I = new Vertex(8, "I");
		Vertex J = new Vertex(9, "J");
		Vertex K = new Vertex(10,"K");

		 switch (start) {
         case "A":  startVert = A;
                  break;
         case "B":  startVert = B;
                  break;
         case "C":  startVert = C;
                  break;
         case "D":  startVert = D;
                  break;
         case "E":  startVert = E;
                  break;
         case "G":  startVert = G;
                  break;
         case "H":  startVert = H;
                  break;
         case "I":  startVert = I;
                  break;
         case "J":  startVert = J;
                  break;
         case "K": startVert = K;
                  break;
         default: startVert = null;
                  break;
     }
		
		// Lower Route
		Edge e1 = new Edge("AI", A, I, 1.0);
		Edge e2 = new Edge("IJ", I, J, 0.5);
		Edge e3 = new Edge("JK", J, K, 1.5);
		Edge e4 = new Edge("KD", K, D, 1.0);


		Edge e12 = new Edge("IA", I, A, 1.0);
		Edge e13 = new Edge("JI", J, I, 0.5);
		Edge e14 = new Edge("KJ", K, J, 1.5);
		Edge e15 = new Edge("DK", D, K, 1.0);


		// Upper Route
		Edge e5 = new Edge("AE", A, E, 0.25);
		Edge e6 = new Edge("EG", E, G, 0.25);
		Edge e7 = new Edge("GH", G, H, 0.25);
		Edge e8 = new Edge("HD", H, D, 0.25);

		Edge e16 = new Edge("EA", E, A, 0.25);
		Edge e17 = new Edge("GE", G, E, 0.25);
		Edge e18 = new Edge("HG", H, G, 0.25);
		Edge e19 = new Edge("DH", D, H, 0.25);

		// Middle Route
		Edge e9 = new Edge("AB", A, B, 1.0);
		Edge e10 = new Edge("BC", B, C, 0.75);
		Edge e11 = new Edge("CD", C, D, 0.15);

		Edge e20 = new Edge("BA", B, A, 1.0);
		Edge e21 = new Edge("CB", C, B, 0.75);
		Edge e22 = new Edge("DC", D, C, 0.15);


		g.addEdge(e1);
		g.addEdge(e2);
		g.addEdge(e3);
		g.addEdge(e4);
		g.addEdge(e5);
		g.addEdge(e6);
		g.addEdge(e7);
		g.addEdge(e8);
		g.addEdge(e9);
		g.addEdge(e10);
		g.addEdge(e11);

		g.addEdge(e12);
		g.addEdge(e13);
		g.addEdge(e14);
		g.addEdge(e15);
		g.addEdge(e16);
		g.addEdge(e17);
		g.addEdge(e18);
		g.addEdge(e19);
		g.addEdge(e20);
		g.addEdge(e21);
		g.addEdge(e22);

		// Testing purposes

		PathFinder p = new PathFinder();
		// Something is wrong with routeToTake. Or the data structure. Hopefully it's routeToTake.
		List<Vertex> verts = null;
		// System.out.println(p.findPath(g, A, 1.0));
		if(startVert != null) {
			verts = p.findPath(g, startVert, distance);

			for (Vertex v : verts) {
				System.out.print(v.letter);
				System.out.print(" > ");
			}
		}
		
		else {
			System.out.println("Invalid vertex entered.");
		}

		//  for (Edge e : g.getAdjList().get(e1.getSource())){
		//    System.out.println(e.getLabel());
		// }

		// Edge v = p.routeToTake(g.getAdjList().get(e1.getSource()));
		//  System.out.println(v.getLabel());
	}
}