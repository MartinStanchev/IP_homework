package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
	private static UserService instance;
	private List<Cars> carList = new ArrayList<>();

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	public UserService() {
		// initial list so it isn't an empty page
		carList.add(new Cars("BMW", "E30", "1.8", "100", "manual"));
		carList.add(new Cars("Mercedes", "190", "2", "150", "automatic"));
		carList.add(new Cars("BMW", "330", "3.0", "230", "manual"));
		carList.add(new Cars("Ford", "Focus", "2", "150", "manual"));
		carList.add(new Cars("Ford", "Fiesta", "1.0", "90", "automatic"));
		carList.add(new Cars("Ford", "Focus", "2.3", "345", "manual"));

	}

	public List<Cars> getCars() {
		return carList;
	}

	public void addCar(Cars car) {
		carList.add(car);
	}

	public PagedResponse getCarsInPagesFiltered(int page, int perPage, String withName) {
		long previousEntries = page * perPage;
		List<Cars> pageOfUsers = carList.stream().filter((u) -> u.getModel().equals(withName) || withName == null)
				.skip(previousEntries).limit(perPage).collect(Collectors.toList());

		int totalPages = (int) Math.ceil(((double) carList.size()) / perPage);
		PagedResponse response = new PagedResponse(pageOfUsers, page, totalPages);

		return response;
	}

	public List<String> getAllDistinctCarModels() {
		return carList.stream()
				.map((u) -> u.getModel())
				.distinct()
				.collect(Collectors.toList());
	}
}
