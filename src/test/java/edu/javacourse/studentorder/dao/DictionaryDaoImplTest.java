package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.domain.PassportOffice;
import edu.javacourse.studentorder.domain.Street;
import edu.javacourse.studentorder.exception.DaoException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class DictionaryDaoImplTest {
    /**
     * @BeforeClass - вызывается один раз в самом начале
     * @Before - выполняется перед каждым выполнением метода с @Test
     * C @After  аналогично
     */
    private  static  final Logger logger = LoggerFactory.getLogger(DictionaryDaoImplTest.class);

    @BeforeClass
    public static void startUp() throws Exception {
        DBInit.dbInit();
    }

    @Test
    public void testStreet() throws DaoException {
        LocalDateTime localDateTime = LocalDateTime.now();
        logger.info("TEST {} {}", localDateTime.toString(), localDateTime.toString());
        List<Street> findStreets = new DictionaryDaoImpl().findStreets("про");
        Assert.assertTrue(findStreets.size() == 2);
    }

    @Test
    public void testPassportOffice() throws DaoException {
        List<PassportOffice> findPassportOffice = new DictionaryDaoImpl().findPassportOffices("010020000000");
        Assert.assertTrue(findPassportOffice.size() == 2);
    }


}