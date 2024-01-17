package Application_Based;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    private String name;
    private boolean isFile;
    private List<TreeNode> children;

    public TreeNode(String name, boolean isFile) {
        this.name = name;
        this.isFile = isFile;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isFile() {
        return isFile;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }
}

class FileSystem {
    private TreeNode root;

    public FileSystem() {
        this.root = new TreeNode("root", false);
    }

    public void addDirectory(String path) {
        String[] directories = path.split("/");
        TreeNode current = root;

        for (String directory : directories) {
            if (!directory.isEmpty()) {
                boolean found = false;
                for (TreeNode child : current.getChildren()) {
                    if (child.getName().equals(directory) && !child.isFile()) {
                        current = child;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    TreeNode newDirectory = new TreeNode(directory, false);
                    current.addChild(newDirectory);
                    current = newDirectory;
                }
            }
        }
    }

    public void addFile(String filePath) {
        String[] pathComponents = filePath.split("/");
        String fileName = pathComponents[pathComponents.length - 1];
        String directoryPath = filePath.substring(0, filePath.length() - fileName.length() - 1);

        TreeNode directory = findDirectory(directoryPath);
        if (directory != null) {
            TreeNode newFile = new TreeNode(fileName, true);
            directory.addChild(newFile);
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }
    }

    private TreeNode findDirectory(String path) {
        String[] directories = path.split("/");
        TreeNode current = root;

        for (String directory : directories) {
            if (!directory.isEmpty()) {
                boolean found = false;
                for (TreeNode child : current.getChildren()) {
                    if (child.getName().equals(directory) && !child.isFile()) {
                        current = child;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    return null;
                }
            }
        }

        return current;
    }

    public void printFileSystem() {
        printFileSystem(root, 0);
    }

    private void printFileSystem(TreeNode node, int level) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("  ");
        }

        System.out.println(indent + (node.isFile() ? "[File] " : "[Directory] ") + node.getName());

        for (TreeNode child : node.getChildren()) {
            printFileSystem(child, level + 1);
        }
    }
}

public class FileSystemSimulation {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        fileSystem.addDirectory("root/home/user1");
        fileSystem.addDirectory("root/home/user2");
        fileSystem.addDirectory("root/work/project1");

        fileSystem.addFile("root/home/user1/file1.txt");
        fileSystem.addFile("root/home/user2/file2.txt");
        fileSystem.addFile("root/work/project1/file3.txt");

        System.out.println("File System Structure:");
        fileSystem.printFileSystem();
    }
}
