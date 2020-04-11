package reference;

import java.util.ArrayList;

public interface TruckMapper {

	public TruckVO select(String truckID);

	public ArrayList<TruckVO> selectall();

}