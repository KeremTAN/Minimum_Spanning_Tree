import java.util.Arrays;

public class FindMST {

    int numberOfVertices; //Number of vertices
    int numberOfEdges; //number of edges
    private int[] vertices; // Vertices array
    private Edge[] MST; // Minimum Spanning Tree Array
    private int mstCost; // Minimum Spanning Tree Cost

    /**
     * Constructor
     *
     * @param edges
     */
    public FindMST(Edge[] edges) {
        this.numberOfEdges=edges.length;
        int max=0;
        for (Edge edge : edges) {
            if (edge.getVertex1() > max) {
                max = edge.getVertex1();
            }
            if (edge.getVertex2() > max) {
                max = edge.getVertex2();
            }
        }
        this.numberOfVertices= max+1;

        vertices = new int[numberOfVertices];

        for(int i = 0; i < numberOfVertices; i++)
            vertices[i]=i;
    }

    /**
     * A utility function to find set of an element i (uses path compression technique)
     *
     * @param subsets
     * @param v
     * @return
     */
    private int find(Subset[] subsets, int v) {
        if (subsets[v].parent != v)
            subsets[v].parent = find(subsets, subsets[v].parent);
        return subsets[v].parent;
    }


    /**
     * A function that does union of two sets of x and y (uses union by rank)
     *
     * @param subsets
     * @param x
     * @param y
     */
    private void Union(Subset[] subsets, int x, int y) {
        int xRt = find(subsets, x);
        int yRt = find(subsets, y);

        if (subsets[xRt].rank < subsets[yRt].rank)
            subsets[xRt].parent = yRt;
        else if (subsets[xRt].rank > subsets[yRt].rank)
            subsets[yRt].parent = xRt;
        else {
            subsets[yRt].parent = xRt;
            subsets[xRt].rank++;
        }
    }

    /**
     * Define all vertices from Edge array and return Vertex array
     *
     * @param edges
     * @return
     */
    private int[] CreateVertices(Edge[] edges) {
        return this.vertices;
    }

    /**
     * Main calculate Minimum Spanning Tree method
     *
     * @param edges
     */
    public void calculateMST(Edge[] edges) {

        Edge[] newMST = new Edge[numberOfVertices];
        int eg = 0;
        int ix = 0;
        Arrays.sort(edges);
        Subset[] subsets = new Subset[numberOfVertices];
        for (ix = 0; ix < numberOfVertices; ++ix)
            subsets[ix] = new Subset();

        for (int v = 0; v < numberOfVertices; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        ix = 0;
        while (eg < numberOfVertices - 1)
        {
            Edge next_edge = edges[ix++];
            int x = find(subsets, next_edge.getVertex1());
            int y = find(subsets, next_edge.getVertex2());
            if (x != y) {
                newMST[eg++] = next_edge;
                Union(subsets, x, y);
            }
        }
        int minCost = 0;
        for (ix = 0; ix < eg; ++ix)
        {
            System.out.println(newMST[ix].getVertex1() + " -- "+ newMST[ix].getVertex2()+ " == " + newMST[ix].getWeight());
            minCost += newMST[ix].getWeight();
        }

        this.mstCost= minCost;
        this.MST=newMST;
    }

    /**
     * Get calculated Minimum Spanning Tree ArrayList
     *
     * @return
     */
    public Edge[] getMST() {
        return MST;
    }

    /**
     * Check vertex is included given arr[] or not
     * @param arr
     * @param vertex
     * @return
     */
    private boolean isVertexIncluded(int[] arr, int vertex) {
        return Arrays.asList(arr).contains(vertex);
    }

    /**
     * Get cost of Minimum Spanning Tree
     *
     * @return
     */
    public int getMstCost() {
        return mstCost;
    }

    /**
     * Print Minimum Spanning Tree info
     */
    public void printMST() {

        for(int i =0;i<this.MST.length-1;i++){

            System.out.println(MST[i].toString());

        }
    }
}
