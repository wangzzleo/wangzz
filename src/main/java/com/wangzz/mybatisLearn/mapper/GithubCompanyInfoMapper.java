package com.wangzz.mybatisLearn.mapper;

import com.wangzz.mybatisLearn.bean.GithubCompanyInfo;

public interface GithubCompanyInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_company_info
     *
     * @mbg.generated Thu Jun 06 10:25:05 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_company_info
     *
     * @mbg.generated Thu Jun 06 10:25:05 CST 2019
     */
    int insert(GithubCompanyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_company_info
     *
     * @mbg.generated Thu Jun 06 10:25:05 CST 2019
     */
    int insertSelective(GithubCompanyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_company_info
     *
     * @mbg.generated Thu Jun 06 10:25:05 CST 2019
     */
    GithubCompanyInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_company_info
     *
     * @mbg.generated Thu Jun 06 10:25:05 CST 2019
     */
    int updateByPrimaryKeySelective(GithubCompanyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_company_info
     *
     * @mbg.generated Thu Jun 06 10:25:05 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(GithubCompanyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table github_company_info
     *
     * @mbg.generated Thu Jun 06 10:25:05 CST 2019
     */
    int updateByPrimaryKey(GithubCompanyInfo record);

    void loadData(String filePath);
}