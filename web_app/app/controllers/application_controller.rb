class ApplicationController < ActionController::Base
  include ActionController::ImplicitRender
  include ActionController::Serialization
  
  before_action :configure_permitted_parameters, if: :devise_controller?

  respond_to :json, :html

  protected

  def configure_permitted_parameters
    devise_parameter_sanitizer.for(:sign_up) << :name
    devise_parameter_sanitizer.for(:account_update) << :name
  end
end
