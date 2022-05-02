public class Worker extends Customers{
    private boolean clubMember1;
    private RankType rankType;

    public Worker(String firstName, String lastName, String users, String password , boolean clubMember , RankType rankType) {
        super(firstName, lastName, users, password , clubMember);
        this.rankType = rankType;
    }
    public boolean isClubMember(){
        return clubMember1;
    }

    public Worker(){
        super();

    }

    public RankType getRankType() {
        return rankType;
    }

    public void setClubMember(boolean clubMember) {
        this.clubMember1 = clubMember;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "clubMember1=" + clubMember1 +
                ", rankType=" + rankType +
                '}';
    }
}
