package com.nouhoun.springboot.jwt.integration.domain;

public class PasswordChangeRequest
{
    String oldPassword;
    String newPassword;
    
    public PasswordChangeRequest()
    {
        super();
    }

    public PasswordChangeRequest(String oldPassword, String newPassword)
    {
        super();
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getOldPassword()
    {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword)
    {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword()
    {
        return newPassword;
    }

    public void setNewPassword(String newPassword)
    {
        this.newPassword = newPassword;
    }
    
}
