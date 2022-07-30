package com.gotriva.testing.antifa.factory.impl;

import com.gotriva.testing.antifa.element.Interactable;
import com.gotriva.testing.antifa.exception.InteractableTypeNotFoundException;
import com.gotriva.testing.antifa.factory.AbstractElementFactory;

import java.util.Map;
import org.openqa.selenium.WebElement;

/**
 * This class creates interactables from abstract elements given type name or
 * default action.
 */
public class InteractableAbstractElementFactory {

  /** The mapped type creators */
  private Map<String, AbstractElementFactory<?>> elementFactoryMap;

  /** Default constructor */
  InteractableAbstractElementFactory(Map<String, AbstractElementFactory<?>> elementFactoryMap) {
    this.elementFactoryMap = elementFactoryMap;
  }

  /**
   * Creates an interactable from a type name.
   *
   * @param element
   * @param typeName
   * @return
   */
  public Interactable createInteractableFromType(WebElement element, String typeName) {
    AbstractElementFactory<?> creator = elementFactoryMap.get(typeName);
    if (creator == null) {
      throw new InteractableTypeNotFoundException(typeName);
    }
    return creator.create(element);
  }
}