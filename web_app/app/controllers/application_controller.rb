class ApplicationController < ActionController::API
  include ActionController::ImplicitRender
  include ActionController::Serialization

  respond_to :json
end
