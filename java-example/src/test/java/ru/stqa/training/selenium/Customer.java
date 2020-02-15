package ru.stqa.training.selenium;

public class Customer {
   private String name;
   private String password;

  public static Builder newEntity() { return new Customer().new Builder(); }

  public String getEmail() {
    return name;
  }

  public String getPassword() {
    return password;
  }

    public class Builder {
      private Builder() {}
      public Builder withEmail(String name) { Customer.this.name = name; return this; }
      public Builder withPassword(String password) { Customer.this.password = password; return this; }
      public Customer build() {return Customer.this; }
  }
}

