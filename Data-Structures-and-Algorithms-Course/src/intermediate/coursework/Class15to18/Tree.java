package intermediate.coursework.Class15to18;

import java.util.ArrayList;

//A demonstration of the usefulness of the Tree data structure.
public class Tree {

    TreeNodeComponent root;

    public Tree(String deptName) {
        root = new TreeNodeComponent(deptName);
    }

    public void buildTree() {
        root.setNumberOfEmployees(35);
        TreeNodeComponent ctnSale = root.addChild("Sales");
        ctnSale.setNumberOfEmployees(15);
        TreeNodeComponent ctnMan = root.addChild("Manufacturing");
        ctnMan.setNumberOfEmployees(6);
        TreeNodeComponent ctnRN = root.addChild("R&D");
        ctnRN.setNumberOfEmployees(20);
        TreeNodeComponent ctnUS = ctnSale.addChild("US");
        ctnUS.setNumberOfEmployees(29);
        TreeNodeComponent ctnInt = ctnSale.addChild("International");
        ctnInt.setNumberOfEmployees(12);
        TreeNodeComponent ctnEurope = ctnInt.addChild("Europe");
        ctnEurope.setNumberOfEmployees(45);
        TreeNodeComponent ctnAsia = ctnInt.addChild("Asia");
        ctnAsia.setNumberOfEmployees(34);
        TreeNodeComponent ctnCanada = ctnInt.addChild("Canada");
        ctnCanada.setNumberOfEmployees(78);
        TreeNodeComponent ctnLap = ctnMan.addChild("Laptops");
        ctnLap.setNumberOfEmployees(34);
        TreeNodeComponent ctnDesk = ctnMan.addChild("Desktops");
        ctnDesk.setNumberOfEmployees(62);
    }

    public void traversal(TreeNodeComponent ctn) {
        if (ctn == null) return;
        System.out.println(ctn.dn + " has " + ctn.children.size() + " children and " + ctn.numberOfEmployees
                + "employees (or subdivisions).");
        System.out.println(ctn.dn + " has " + getTotalNumberOfEmployees(ctn) + "employees");
        for (int i = 0; i < ctn.children.size(); i++)
            traversal(ctn.children.get(i));
    }

    public int computeSubTreeSize(TreeNodeComponent ctn) {
        if (ctn == null) {
            return 0;
        }
        int subTreeSize = 1;
        System.out.println(ctn.dn + " has " + ctn.children.size() + " children");
        for (int i = 0; i < ctn.children.size(); i++) {
            subTreeSize += computeSubTreeSize(ctn.children.get(i));
        }
        System.out.println(ctn.dn + " has a size of " + subTreeSize);
        return subTreeSize;
    }

    public int getTotalNumberOfEmployees(TreeNodeComponent ctn) {
        if (ctn == null) {
            return 0;
        }
        int numberOfEmployees = ctn.numberOfEmployees;
        System.out.println(ctn.dn + " has " + ctn.children.size() + " children");
        for (int i = 0; i < ctn.children.size(); i++) {
            numberOfEmployees += computeSubTreeSize(ctn.children.get(i));
        }
        System.out.println(ctn.dn + " has a total of " + numberOfEmployees + " employees.");
        return numberOfEmployees;
    }

    public static void main(String[] args) {
        Tree test = new Tree("Computers \"R\" Us");
        System.out.println("Building tree...");
        test.buildTree();
        System.out.println();

        System.out.println("Performing a traversal of the tree.");
        test.traversal(test.root);
        System.out.println();

        System.out.println("Size of the tree: ");
        test.computeSubTreeSize(test.root);
        System.out.println();

        System.out.println("Total number of employees: ");
        test.getTotalNumberOfEmployees(test.root);
        System.out.println();
    }
}

class TreeNodeComponent {
    String dn;
    int numberOfEmployees;
    ArrayList<TreeNodeComponent> children;

    public TreeNodeComponent(String name) {
        dn = name;
        children = new ArrayList();
    }

    public TreeNodeComponent addChild(String childName) {
        TreeNodeComponent ctn = new TreeNodeComponent(childName);
        children.add(ctn);
        return ctn;
    }

    public void setNumberOfEmployees(int ne) {
        numberOfEmployees = ne;
    }
}