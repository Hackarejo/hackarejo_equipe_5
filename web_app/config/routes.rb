Rails.application.routes.draw do
  root 'welcome#index'
  
  devise_for :people
  
  resources :products

  scope defaults: { format: :json } do

    get 'welcome', action: :index, controller: :welcome
  end

  namespace :api, defaults: { format: :json } do
    namespace :v1, except: [:new, :edit] do
      resources :vouchers
      resources :offers
      resources :products
      resources :companies
      resources :tags

      resources :people do
        get 'find_by', on: :collection
      end
    end
  end
end