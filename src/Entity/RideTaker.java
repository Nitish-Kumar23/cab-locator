package Entity;

public class RideTaker {
    
    private Integer id;
    
    private String name;

    private Double averageRating;

    private Integer rideCount;

    public RideTaker() {
    }

    public RideTaker(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public RideTaker(Integer id, String name, Double averageRating, Integer rideCount) {
        this.id = id;
        this.name = name;
        this.averageRating = averageRating;
        this.rideCount = rideCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getRideCount() {
        return rideCount;
    }

    public void setRideCount(Integer rideCount) {
        this.rideCount = rideCount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RideTaker{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", averageRating=").append(averageRating);
        sb.append(", rideCount=").append(rideCount);
        sb.append('}');
        return sb.toString();
    }
}
