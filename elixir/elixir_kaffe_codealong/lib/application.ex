defmodule ElixirKaffeCodealong.Application do
  use Application

  def start(_type, _args) do
    import Supervisor.Spec

    children = [
      # calls to start Kaffe's Consumer module
      worker(Kaffe.Consumer, [])
    ]

    opts = [strategy: :one_for_one, name: ExampleConsumer.Supervisor]
    Supervisor.start_link(children, opts)
  end
end
