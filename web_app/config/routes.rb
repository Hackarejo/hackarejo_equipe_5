Rails.application.routes.draw do
  scope defaults: { format: :json } do
    root 'welcome#index'

    get 'welcome', action: :index, controller: :welcome
  end

  namespace :api, defaults: { format: :json } do
    namespace :v1, except: [:new, :edit] do
      resources :locations
      resources :vouchers
      resources :offers
      resources :products
      resources :companies
      
      resources :people do
        get :find_by, on: :collection
      end

      resources :statuses
    end
  end
end