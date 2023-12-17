package com.example.testManagement.adapter.database;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.testManagement.application.ITestCaseRepo;
import com.example.testManagement.domain.model.TestCase;
import com.example.testManagement.domain.model.TestCaseId;
import com.example.testManagement.domain.model.UserStoryId;

@Component
public class DBTestCaseRepo implements ITestCaseRepo {
	
	private final JDBCTestCaseEntityRepo jdbcTestCaseEntityRepo;
	
	@Autowired
	public DBTestCaseRepo(JDBCTestCaseEntityRepo jdbcTestCaseEntityRepo) {
		this.jdbcTestCaseEntityRepo = jdbcTestCaseEntityRepo;
	}

	@Override
	public TestCase findById(TestCaseId testCaseId) {
		Optional<TestCaseEntity> testCaseEntity = jdbcTestCaseEntityRepo.findById(testCaseId.getId());
        if (testCaseEntity.isPresent()) {
            return testCaseEntity.get().toDomain();
        } else {
            return null;
        }
	}

	@Override
	public Collection<TestCase> findByUserStoryId(UserStoryId userStoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TestCase testCase) {
		jdbcTestCaseEntityRepo.save(new TestCaseEntity(testCase));
	}

}
