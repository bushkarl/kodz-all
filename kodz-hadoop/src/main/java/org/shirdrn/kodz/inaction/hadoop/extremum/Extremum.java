package org.shirdrn.kodz.inaction.hadoop.extremum;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Writable;

public class Extremum implements Writable {

	private LongWritable maxValue;
	private LongWritable minValue;
	
	public Extremum() {
		super();
		maxValue = new LongWritable(0);
		minValue = new LongWritable(0);
	}
	
	public Extremum(long min, long max) {
		super();
		this.minValue = new LongWritable(min);
		this.maxValue = new LongWritable(max);
	}
	
	@Override
	public void readFields(DataInput in) throws IOException {
		this.minValue = new LongWritable(in.readLong());
		this.maxValue = new LongWritable(in.readLong());
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeLong(minValue.get());
		out.writeLong(maxValue.get());
	}

	public LongWritable getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(LongWritable maxValue) {
		this.maxValue = maxValue;
	}

	public LongWritable getMinValue() {
		return minValue;
	}

	public void setMinValue(LongWritable minValue) {
		this.minValue = minValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(minValue.get()).append("\t").append(maxValue.get());
		return builder.toString();
	}

}
