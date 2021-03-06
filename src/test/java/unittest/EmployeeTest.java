package unittest;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import unittest.Employee.Department;

/**
 * {@link Employee}に対するテストクラス。
 *
 * @author kyougoku.n
 */
public class EmployeeTest {

    private Employee testee;

    @Before
    public void setUp() throws Exception {
        testee = new Employee(123);
        testee.setName("オプスト", "太郎");
        testee.setDepartment(Department.DEVELOPMENT);
    }

    @Test
    public void isSameDepartment_部署判定が正しく行われること() throws Exception {
        // 同じ部署の場合
        assertThat(testee.isSameDepartment(Department.DEVELOPMENT)).isTrue();

        // 異なる部署の場合
        assertThat(testee.isSameDepartment(Department.FINANCE)).isFalse();

        // null 指定の場合
        assertThat(testee.isSameDepartment(null)).isFalse();
    }

    @Test
    public void equals_従業員の比較が行われること() throws Exception {
        // 同一社員番号の場合
        Employee target = new Employee(123);
        assertThat(testee.equals(target)).isTrue();

        // 異なる社員番号の場合
        target = new Employee(234);
        assertThat(testee.equals(target)).isFalse();
    }

    @Test
    public void toString_文字列表現を取得できること() throws Exception {
        assertThat(testee.toString()).isEqualTo("[00123]オプスト 太郎");
        assertThat(testee).hasToString("[00123]オプスト 太郎");
    }
}
