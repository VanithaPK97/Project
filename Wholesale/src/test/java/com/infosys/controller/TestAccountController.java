package com.infosys.controller;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infosys.dto.TransactionDto;
import com.infosys.service.AccountServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class TestAccountController {

	@Autowired
	private MockMvc mvc;
	@MockBean
	AccountServiceImpl accountService;

	@Test
	public void getTransDetailsTest() throws Exception {
		List<TransactionDto> transList = new ArrayList<TransactionDto>();
		TransactionDto transOne = new TransactionDto(79106619, "AUSavings933", null, "AUD", 0.0, 3801.45, "Credit", "");
		TransactionDto transTwo = new TransactionDto(79106619, "AUSavings933", null, "AUD", 2978.43, 0.0, "Debit", "");
		transList.add(transOne);
		transList.add(transTwo);

		Mockito.when(accountService.getAllTransactions(Mockito.anyInt())).thenReturn(transList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/transactions/{accountNumber}", 79106619)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result;
		result = mvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		ObjectMapper mapper = new ObjectMapper();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		mapper.writeValue(out, transList);

		int status = response.getStatus();
		byte[] data = out.toByteArray();

		Assert.assertEquals(new String(data), response.getContentAsString());
		Assert.assertEquals("Correct Response", HttpStatus.OK.value(), status);
	}

}
