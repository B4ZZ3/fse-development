package com.example.testing.application;

import java.util.Collection;

import com.example.testing.domain.model.TestCase;
import com.example.testing.domain.model.TestCaseId;
import com.example.testing.domain.model.TestStatus;

public interface ITestCaseRepo {

	public TestCase findById(TestCaseId testCaseId);
	public Collection<TestCase> findByTestStatus(TestStatus testStatus);
	public void save(TestCase testCase);
}
