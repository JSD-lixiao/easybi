package org.imw.easybi.dao;

import org.imw.easybi.pojo.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailDao extends JpaRepository<Mail,String> {
    Mail getMailByMailUrl(String mailUrl);
}
