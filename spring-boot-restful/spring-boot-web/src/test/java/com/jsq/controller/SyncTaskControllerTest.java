package com.jsq.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class SyncTaskControllerTest {

    private SyncTaskController syncTaskController =new SyncTaskController();


    @Test
    public void syncTask() {
        syncTaskController.syncTask();
    }
    @Test
    public void test3(){
        syncTaskController.test3();
    }
}