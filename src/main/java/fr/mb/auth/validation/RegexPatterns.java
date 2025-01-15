package fr.mb.auth.validation;

public final class RegexPatterns {
	
	private RegexPatterns() {}

    public static final String USERNAME_PATTERN = "^[a-zA-Z0-9_.]+$";
    
    public static final String PASSWORD_PATTERN = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]";
    
}