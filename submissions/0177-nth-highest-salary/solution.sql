CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      SELECT salary
      FROM Employee e1
      WHERE (
          SELECT COUNT(DISTINCT salary)
          FROM Employee e2
          WHERE e2.salary >= e1.salary
      ) = N
      LIMIT 1
  );
END

