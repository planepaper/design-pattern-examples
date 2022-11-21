package hiroshi.VisitorProblem;

import java.util.Iterator;

public class FileFindVisitor extends Visitor {
    private String currentdir = "";
    private String queryExtension = "";

    public FileFindVisitor(String queryExtension)
    {
        this.queryExtension = queryExtension;
    }

    public void visit(File file) {
        String fileExtension = makeExtensionString(file.getName());

        if(fileExtension.compareTo(queryExtension) == 0)
        {
            System.out.println(currentdir + "/" + file);
        }
    }
    public void visit(Directory directory) {
        String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            entry.accept(this);
        }
        currentdir = savedir;
    }

    private String makeExtensionString(String fileName)
    {
        String[] result = fileName.split("\\.");

        if(result.length > 0)
        {
            return result[result.length - 1];
        }
        return "";
    }
}
