package n09_string_manipulation;

import java.util.HashMap;

public class LC1166DesignFileSystem
{
    /*
    HashMap<String, Integer> fs;

    public LC1166DesignFileSystem()
    {
        fs = new HashMap<>();
    }

    public boolean createPath(String path, int value)
    {
        if (fs.containsKey(path)) return false;
        String[] dirs = path.split("/");
        String dir = "";
        for (int i = 0; i < dirs.length - 1; i++)
        {
            if (dirs[i].equals("")) continue;
            dir = dir + "/" + dirs[i];
            if (!fs.containsKey(dir)) return false;
        }
        fs.put(path, value);
        return true;
        if (fs.containsKey(path)) return false;
        String parent = path.substring(0, path.lastIndexOf("/"));
        if (!parent.equals("") && !fs.containsKey(path.substring(0, path.lastIndexOf("/")))) return false;
        fs.put(path, value);
        return true;
    }

    public int get(String path)
    {
        if (!fs.containsKey(path)) return -1;
        return fs.get(path);
    }
    */
    HashMap<String, Integer> fs;

    public LC1166DesignFileSystem()
    {
        fs = new HashMap<>();
        fs.put("", -1);
    }

    public boolean createPath(String path, int value)
    {
        if (fs.containsKey(path) || !fs.containsKey(path.substring(0, path.lastIndexOf("/")))) return false;
        fs.put(path, value);
        return true;
    }

    public int get(String path)
    {
        return fs.getOrDefault(path, -1);
    }
}
