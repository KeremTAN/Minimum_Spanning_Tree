

public class Edge implements Comparable<Edge>{
    private int vertex1;
    private int vertex2;
    private int weight;

    /**
     * Constructor
     *
     * @param v1
     * @param v2
     * @param w
     */
    public Edge(int v1, int v2, int w) {
        this.setVertex1(v1);
        this.setVertex2(v2);
        this.setWeight(w);
    }

    /**
     * Get vertex1 method
     *
     * @return
     */
    public int getVertex1() {
        return vertex1;
    }

    /**
     * Set vertex1 method
     *
     * @param vertex1
     */
    public void setVertex1(int vertex1) {
        this.vertex1 = vertex1;
    }

    /**
     * Get vertex2 method
     *
     * @return
     */
    public int getVertex2() {
        return vertex2;
    }

    /**
     * Set vertex2 method
     *
     * @param vertex2
     */
    public void setVertex2(int vertex2) {
        this.vertex2 = vertex2;
    }

    /**
     * Get weight method
     *
     * @return
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Set weight method
     *
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Compare method order by weight
     * @param compareEdge
     * @return
     */
    public int compareTo(Edge compareEdge)
    {
        return this.weight - compareEdge.weight;
    }

    /**
     * If 2 object equals return true, else return false
     * @param edge
     * @return
     */
    public boolean equals(Edge edge) {
        boolean retVal = false;

        if (this.getVertex1() == edge.getVertex1() && this.getVertex2() == edge.getVertex2()
                && this.getWeight() == edge.getWeight()) {
            retVal = true;
        }

        if (this.getVertex1() == edge.getVertex2() && this.getVertex2() == edge.getVertex1()
                && this.getWeight() == edge.getWeight()) {
            retVal = true;
        }

        return retVal;
    }

    /**
     * return the Edge info
     * @return
     */
    public String toString() {
        return this.getVertex1() + " - " + this.getVertex2() + "  " + this.getWeight();
    }

}
