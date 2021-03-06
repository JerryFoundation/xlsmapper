package com.gh.mygreen.xlsmapper.validation;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.MessageSourceAccessor;


/**
 * MessageResolver via Spring 'org.springframework.context.MessageSource'.
 * 
 * @author T.TSUCHIE
 *
 */
public class SpringMessageResolver implements MessageResolver {
    
    protected MessageSourceAccessor messageSourceAccessor;
    
    public SpringMessageResolver() {
        
    }
    
    public SpringMessageResolver(final MessageSource messageSource) {
        setMessageSource(messageSource);
    }
    
    /**
     * {@inheritDoc}
     */
    public String getMessage(final String code) {
        try {
            return messageSourceAccessor.getMessage(code);
        } catch(NoSuchMessageException e) {
            return null;
        }
    }
    
    public void setMessageSource(final MessageSource messageSource) {
        this.messageSourceAccessor = new MessageSourceAccessor(messageSource);
    }
    
    protected MessageSourceAccessor getMessageSourceAccessor() {
        return messageSourceAccessor;
    }
}
