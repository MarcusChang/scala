// $Id$

// Test 1: "super" coming from mixins

object Test1 {
  class A {
    def f = "A::f";
  }

  class B extends A {
    override def f = "B::f";
  }

  class M1 extends A {
    override def f = "M1::" + super.f;
  }

  class C extends B with M1 {
  }

  def main(args: Array[String]): Unit = {
    val c = new C;
    System.out.println(c.f);
  }
}

// Test 2: qualified "super" inside of the host class

object Test2 {
  class M1 {
    def f = "M1::f";
  }

  class M2 {
    def f = "M2::f";
  }

  class M3 {
    def f = "M3::f";
  }

  class Host with M1 with M2 with M3 {
    override def f = super[M1].f + " " + super[M2].f + " " + super[M3].f
  }

  def main(args: Array[String]): Unit = {
    val h = new Host;
    System.out.println(h.f)
  }
}

// Main testing function

object Test {
  def main(args: Array[String]): Unit = {
    Test1.main(args);
    Test2.main(args);
  }
}
