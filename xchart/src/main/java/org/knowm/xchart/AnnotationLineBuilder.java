package org.knowm.xchart;

import org.knowm.xchart.internal.chartpart.AnnotationBuilder;

/** @author timmolter */
public class AnnotationLineBuilder extends AnnotationBuilder<AnnotationLine> {

	//optional
	private boolean isVertical;
	private double value;

  public AnnotationLineBuilder(boolean isValueInScreenSpace){
	  super(isValueInScreenSpace);
  }
 
  public AnnotationLineBuilder setIsVertical(boolean isVertical) {
	  this.isVertical = isVertical;
      return this;
  }
  
  public AnnotationLineBuilder setValue(double value) {
	  this.value = value;
      return this;
  }
  
  public boolean getIsVertical() {
	  return this.isVertical;
  }
  
  public double getValue() {
	  return this.value;
  }

  /**
   * return fully built XYChart
   *
   * @return a XYChart
   */
  
  @Override
  public AnnotationLine build() {
	  return new AnnotationLine(this);
  }
}
