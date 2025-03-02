package org.knowm.xchart.internal.chartpart;

import org.knowm.xchart.style.PieStyler;

import java.text.DecimalFormat;

public class PieLabelFormatName implements PieLabelFormat {
    private final DecimalFormat df = new DecimalFormat("#.0");

    @Override
    public String format(String name, Number y) {
        return name;
    }

    @Override
    public PieStyler.LabelType getType() {
        return PieStyler.LabelType.Name;
    }
}
