package ru.gvozdilin.springmvc1.springmvcwebapp2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ru.gvozdilin.springmvc1.springmvcwebapp2.model.User;
import ru.gvozdilin.springmvc1.springmvcwebapp2.repository.UserRepository;

@Service
public class UserService {

	private static int[] months = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	@Autowired
	private UserRepository userRepository;

	public User findById(Long id) {

		return userRepository.getOne(id);
	}

	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	public Page<User> findAll(PageRequest pages) {

		return userRepository.findAll(pages);
	}

	public User saveUser(User user) {

		return userRepository.save(user);
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	public String calculateDaysDifference(User user1, User user2) {

		String[] datesOne = user1.getBirthDay().split("-");
		String[] datesTwo = user2.getBirthDay().split("-");

		int yearFirstUser = Integer.parseInt(datesOne[0]);
		int yearSecondUser = Integer.parseInt(datesTwo[0]);

		int monthFirstUser = Integer.parseInt(datesOne[1]);
		int monthSecondUser = Integer.parseInt(datesTwo[1]);

		int daysFirstUser = Integer.parseInt(datesOne[2]);
		int daysSecondUser = Integer.parseInt(datesTwo[2]);

		int completeFirstUserDays = daysFirstUser;
		int completeSecondUserDays = daysSecondUser;

		for (int i = 0; i < monthFirstUser - 1; i++) {
			completeFirstUserDays += months[i];
		}

		for (int i = 0; i < monthSecondUser - 1; i++) {
			completeSecondUserDays += months[i];
		}

		if (yearFirstUser < yearSecondUser) {

			int result = (yearSecondUser - (yearFirstUser + 1)) * 365 + (365 - completeFirstUserDays)
					+ completeSecondUserDays;

			return user1.getFirstName() + " " + user1.getLastName() + " старше " + user2.getFirstName() + " "
					+ user2.getLastName() + " на " + result + " дней";

		}

		else if (yearFirstUser > yearSecondUser) {
			int result = (yearFirstUser - (yearSecondUser + 1)) * 365 + (365 - completeSecondUserDays)
					+ completeFirstUserDays;

			return user2.getFirstName() + " " + user2.getLastName() + " старше " + user1.getFirstName() + " "
					+ user1.getLastName() + " на " + result + " дней";
		}

		else {
			if (monthFirstUser > monthSecondUser) {
				int result = (completeFirstUserDays - completeSecondUserDays);

				return user2.getFirstName() + " " + user2.getLastName() + " старше " + user1.getFirstName() + " "
						+ user1.getLastName() + " на " + result + " дней";
			}

			else if (monthFirstUser < monthSecondUser) {
				int result = (completeSecondUserDays - completeFirstUserDays);

				return user1.getFirstName() + " " + user1.getLastName() + " старше " + user2.getFirstName() + " "
						+ user2.getLastName() + " на " + result + " дней";
			}

			else {
				if (completeFirstUserDays > completeSecondUserDays) {

					return user2.getFirstName() + " " + user2.getLastName() + " старше " + user1.getFirstName() + " "
							+ user1.getLastName() + " на " + (completeFirstUserDays - completeSecondUserDays) + " дней";
				}

				else if (completeFirstUserDays < completeSecondUserDays) {

					return user1.getFirstName() + " " + user1.getLastName() + " старше " + user2.getFirstName() + " "
							+ user2.getLastName() + " на " + (completeSecondUserDays - completeFirstUserDays);
				}

				else {
					return user1.getFirstName() + " " + user1.getLastName() + " и " + user2.getFirstName() + " "
							+ user2.getLastName() + " родились в один день : " + user1.getBirthDay();
				}
			}
		}
	}

}
