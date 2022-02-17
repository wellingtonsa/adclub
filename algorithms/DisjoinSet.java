package algorithms;

import entities.Category;

public class DisjoinSet {

    int[] parents;
    Category[] parentsContent;
    int n;

    public DisjoinSet(int n) {
        this.n = n;
        initSet();
    }

    public void initSet() {
        parents = new int[n];
        parentsContent = new Category[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            parentsContent[i] = new Category();
        }
    }

    public int find(int i) {

        if (parents[i] == i) {

            return i;
        } else {

            return find(parents[i]);
        }
    }

    public Category findPointer(int i){
        if (parents[i] == i) {

            return parentsContent[i];
        } else {

            return findPointer(parents[i]);
        }
    }

    public void union(int i, Category j) {

        int irep = find(i);

        int jrep = find(j.getId());

        if (irep == jrep) {
            return;
        }

        parents[irep] = jrep;
        parentsContent[irep] = j;
        parentsContent[jrep] = j;

    }

    @Override
    public String toString() {

        for (Integer item : parents) {
            System.out.println(item);
        }

        return "";
    }

}