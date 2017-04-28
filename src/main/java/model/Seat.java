package main.java.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public interface Seat {
  public static DateFormat timeFormatter = new SimpleDateFormat("HH:mm a");
  public static final String DEFAULT_START_BOUND = "08:00 am";
  public static final String DEFAULT_END_BOUND = "10:00 pm";
}
