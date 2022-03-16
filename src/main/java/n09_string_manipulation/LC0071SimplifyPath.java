package n09_string_manipulation;

public class LC0071SimplifyPath
{
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        StringBuilder ret = new StringBuilder("");
        int n = split.length;
        int skipCount = 0;


        for (int i = n - 1; i >= 0; i--)
        {
            switch (split[i])
            {
                case "":
                    continue;
                case ".":
                    continue;
                case "..":
                    skipCount++;
                    break;
                default:
                    if (skipCount > 0)
                        skipCount--;
                    else
                        ret.insert(0, "/" + split[i]);
            }
        }

        if (ret.length() == 0) return "/";

        return ret.toString();

    }
}
