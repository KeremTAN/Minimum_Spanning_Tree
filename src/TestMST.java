
import java.io.RandomAccessFile;

public class TestMST {

    /**
     * @param filePath --> graph file absolute path
     * @return --> array containing the information of graph vertices and edges read from the file
     * @throws Exception
     */
    static Edge[] ReadGraph(String filePath) throws Exception {

        String readLine;
        int numEdges = 0;

        // Create a random access file for read graph
        RandomAccessFile graphFile = new RandomAccessFile(filePath, "r");

        //Set pointer in the beginning of file
        graphFile.seek(0);

        // read number of edges
        try {
            readLine = graphFile.readLine();
            numEdges = Integer.parseInt(readLine);
        } catch (Exception e) {
            return new Edge[0];
        }

        Edge[] edges = new Edge[numEdges];
        int index = 0;

        // Read data from a file
        readLine = graphFile.readLine();

        while (readLine != null) {
            String[] tempLine = readLine.split(" ");

            try {
                int v1 = Integer.parseInt(tempLine[0]);
                int v2 = Integer.parseInt(tempLine[1]);
                int w = Integer.parseInt(tempLine[2]);
                edges[index++] = new Edge(v1, v2, w);
            } catch (Exception e) {
                //return new Edge[0];
            }

            readLine = graphFile.readLine();
        }

        // Close the graph file
        graphFile.close();

        return edges;
    }

    /**
     * Check array has contains given element
     * @param edges
     * @param e
     * @return
     */
    static boolean contains(Edge[] edges, Edge e) {
        boolean retVal = false;
        for (Edge edge : edges) {
            if (edge.equals(e)) {
                retVal = true;
                break;
            }
        }
        return retVal;
    }

    /**
     * Main function
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int totalGrade = 0;
        Edge e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13;

        //**********************************************************************************//
        Edge[] graph1 = ReadGraph("src/HW_3/Graphs/graph_1.txt"); //Rad graph_1
        FindMST mst1 = new FindMST(graph1); //Call constructor
        mst1.calculateMST(graph1); //Calculate Minimum Spanning Tree
        mst1.printMST(); // Print Minimum Spanning Tree

        //*************************Calculate Grade******************************************//
        //Check MST total cost
        if(mst1.getMstCost() == 37)
            totalGrade+=10;

        //Check all edges
        e1= new Edge(7,6,1);
        e2= new Edge(8,2,2);
        e3= new Edge(6,5,2);
        e4= new Edge(0,1,4);
        e5= new Edge(2,5,4);
        e6= new Edge(2,3,7);
        e7= new Edge(0,7,8);
        e8= new Edge(3,4,9);

        if(contains(mst1.getMST(), e1))
            totalGrade+=5;
        if(contains(mst1.getMST(), e2))
            totalGrade+=5;
        if(contains(mst1.getMST(), e3))
            totalGrade+=5;
        if(contains(mst1.getMST(), e4))
            totalGrade+=5;
        if(contains(mst1.getMST(), e5))
            totalGrade+=5;
        if(contains(mst1.getMST(), e6))
            totalGrade+=5;
        if(contains(mst1.getMST(), e7))
            totalGrade+=5;
        if(contains(mst1.getMST(), e8))
            totalGrade+=5;
        //*************************End Calculate Grade**************************************//

        //**********************************************************************************//
        Edge[] graph2 = ReadGraph("src/HW_3/Graphs/graph_2.txt"); //Read graph_2
        FindMST mst2 = new FindMST(graph2); //Call constructor
        mst2.calculateMST(graph2); //Calculate Minimum Spanning Tree
        mst2.printMST(); // Print Minimum Spanning Tree

        //*************************Calculate Grade******************************************//
        //Check MST total cost
        if(mst2.getMstCost() == 74)
            totalGrade+=11;

        //Check all edges
        e1= new Edge(5,3,1);
        e2= new Edge(0,5,2);
        e3= new Edge(5,4,3);
        e4= new Edge(8,10,3);
        e5= new Edge(1,2,4);
        e6= new Edge(7,6,5);
        e7= new Edge(12,13,5);
        e8= new Edge(1,11,6);
        e9= new Edge(1,8,7);
        e10= new Edge(6,8,7);
        e11= new Edge(0,9,9);
        e12= new Edge(11,13,10);
        e13= new Edge(9,12,12);

        if(contains(mst2.getMST(), e1))
            totalGrade+=3;
        if(contains(mst2.getMST(), e2))
            totalGrade+=3;
        if(contains(mst2.getMST(), e3))
            totalGrade+=3;
        if(contains(mst2.getMST(), e4))
            totalGrade+=3;
        if(contains(mst2.getMST(), e5))
            totalGrade+=3;
        if(contains(mst2.getMST(), e6))
            totalGrade+=3;
        if(contains(mst2.getMST(), e7))
            totalGrade+=3;
        if(contains(mst2.getMST(), e8))
            totalGrade+=3;
        if(contains(mst2.getMST(), e9))
            totalGrade+=3;
        if(contains(mst2.getMST(), e10))
            totalGrade+=3;
        if(contains(mst2.getMST(), e11))
            totalGrade+=3;
        if(contains(mst2.getMST(), e12))
            totalGrade+=3;
        if(contains(mst2.getMST(), e13))
            totalGrade+=3;
        //*************************End Calculate Grade**************************************//

        System.out.println("\n*****************************************************");
        System.out.println("Total Grade is " + totalGrade);
        System.out.println("*****************************************************");

    }
}
