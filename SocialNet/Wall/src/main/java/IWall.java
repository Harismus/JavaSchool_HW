public interface IWall {
    void write(IPost iPost);

    IPost[] read(int count);
}
