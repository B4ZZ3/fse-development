package com.example.testing.application;

import java.util.Collection;

import com.example.testing.domain.model.TestCase;
import com.example.testing.domain.model.TestCaseId;
import com.example.testing.domain.model.TestCaseTO;
import com.example.testing.domain.model.TestStatus;

public class TestCaseService implements ITestCaseService {
	
	private ITestCaseRepo testCaseRepo;
	
	public TestCaseService(ITestCaseRepo testCaseRepo) {
		this.testCaseRepo = testCaseRepo;
	}

	@Override
	public boolean changeStatusToApproved(int id) {
		
		try {
			TestCase testCase = testCaseRepo.findById(new TestCaseId(id));
			testCase.changeTestStatus(TestStatus.APPROVED);
			testCaseRepo.save(testCase);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean changeStatusToNotApproved(int id) {
		
		try {
			TestCase testCase = testCaseRepo.findById(new TestCaseId(id));
			testCase.changeTestStatus(TestStatus.NOT_APPROVED);
			testCaseRepo.save(testCase);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean processTestCases(Collection<TestCaseTO> testCaseListeTO) {
		// TODO Auto-generated method stub
		return false;
	}

}
