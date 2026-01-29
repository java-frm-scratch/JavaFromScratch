package com.java.from.scratch.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimestampConverter {
    
    // Common timestamp formats
    private static final String[] SUPPORTED_FORMATS = {
        "yyyy-MM-dd HH:mm:ss",    // 2025-01-22 14:30:00
        "yyyy/MM/dd HH:mm:ss",    // 2025/01/22 14:30:00
        "dd-MM-yyyy HH:mm:ss",    // 22-01-2025 14:30:00
        "MM/dd/yyyy hh:mm a",     // 01/22/2025 02:30 PM
        "yyyy-MM-dd'T'HH:mm:ss",  // 2025-01-22T14:30:00 (ISO-8601)
        "E, MMM dd yyyy HH:mm:ss" // Wed, Jan 22 2025 14:30:00
    };
    
    /**
     * Converts a string timestamp to milliseconds since epoch
     * @param timestampStr The timestamp string to convert
     * @param timezone Timezone ID (e.g., "UTC", "America/New_York")
     * @return milliseconds since epoch, or -1 if conversion fails
     */
    public static long stringToMillis(String timestampStr, String timezone) {
        if (timestampStr == null || timestampStr.trim().isEmpty()) {
            return -1;
        }
        
        // Try each supported format
        for (String format : SUPPORTED_FORMATS) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                LocalDateTime localDateTime = LocalDateTime.parse(timestampStr, formatter);
                ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(timezone));
                return zonedDateTime.toInstant().toEpochMilli();
            } catch (DateTimeParseException e) {
                // Try next format
                continue;
            }
        }
        
        // If no format matched
        System.err.println("Error: Could not parse timestamp: " + timestampStr);
        return -1;
    }
    
    /**
     * Converts milliseconds to a formatted string
     * @param millis Milliseconds since epoch
     * @param format Desired output format (e.g., "yyyy-MM-dd HH:mm:ss")
     * @param timezone Timezone ID (e.g., "UTC", "America/New_York")
     * @return Formatted date string
     */
    public static String millisToString(long millis, String format, String timezone) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format)
                .withZone(ZoneId.of(timezone));
        return formatter.format(java.time.Instant.ofEpochMilli(millis));
    }
    
    public static void main(String[] args) {
        // Example usage
        String[] testTimestamps = {
            "2025-01-22 14:30:00",
            "2025/01/22 14:30:00",
            "22-01-2025 14:30:00",
            "01/22/2025 02:30 PM",
            "2025-01-22T14:30:00",
            "Wed, Jan 22 2025 14:30:00"
        };
        
        String timezone = "UTC";
        
        for (String ts : testTimestamps) {
            long millis = stringToMillis(ts, timezone);
            if (millis != -1) {
                System.out.println("Original: " + ts);
                System.out.println("As millis: " + millis);
                System.out.println("Converted back: " + 
                    millisToString(millis, "yyyy-MM-dd HH:mm:ss", timezone));
                System.out.println("---");
            }
        }
    }
}
