package com.gotriva.testing.antifa.handler.impl;

import com.gotriva.testing.antifa.execution.ExecutionContext;
import com.gotriva.testing.antifa.handler.PageObjectActionHandler;

/** This class implements a page object handler for close page action. */
public class ClosePageHandler implements PageObjectActionHandler {

  /** Default constructor */
  ClosePageHandler() {
  }

  @Override
  public String getAction() {
    return "close";
  }

  @Override
  public void handle(ExecutionContext context, String page, String parameter) {
    context.closeCurrentPage();
  }
}
