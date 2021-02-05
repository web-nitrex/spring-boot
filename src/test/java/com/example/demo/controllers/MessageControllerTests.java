package com.example.demo.controllers;

import com.example.demo.models.Message;
import com.example.demo.service.LocalMessageService;
import com.example.demo.service.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MessageController.class)
public class MessageControllerTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MessageService service;

    @Test
    public void getSettingTest() throws Exception {
        given(service.getValueSetting()).willReturn("value1");
        mvc.perform(MockMvcRequestBuilders.get("/get-setting")).andExpect(status().isOk()).andExpect(jsonPath("$.setting", is("value1")));
    }

    @Test
    public void getMessageTest() throws Exception {
        Message request = new Message(1,"----");
        given(service.getMessage(1)).willReturn(new Message(0,"test"));
        mvc.perform(MockMvcRequestBuilders.get("/get-message").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))).andExpect(status().isOk()).andExpect(jsonPath("$.text", is("test")))
                                                                                                     .andExpect(jsonPath("$.id", is(0)));

        Message badRequest= new Message(0,"");
        given(service.getMessage(0)).willReturn(null);
        mvc.perform(MockMvcRequestBuilders.get("/get-message").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(badRequest))).andExpect(status().isBadRequest());
    }

    @Test
    public void saveMessageTest() throws Exception {
        Message request = new Message(0,"save");
        given(service.saveMessage(any())).willReturn(1);
        mvc.perform(MockMvcRequestBuilders.post("/").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))).andExpect(status().isOk()).andExpect(jsonPath("$.text", is("")))
                .andExpect(jsonPath("$.id", is(1)));

        Message badRequest = new Message(0,"");
        mvc.perform(MockMvcRequestBuilders.post("/").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(badRequest))).andExpect(status().isBadRequest());
    }



}
