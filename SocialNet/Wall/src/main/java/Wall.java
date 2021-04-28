import java.util.ArrayList;
import java.util.List;

public class Wall implements IWall{
    private List<IPost> listPosts = new ArrayList<>();


    @Override
    public void write(IPost iPost) {
    }

    @Override
    public IPost[] read(int count) {
        return (IPost[]) listPosts.toArray();
    }
}
