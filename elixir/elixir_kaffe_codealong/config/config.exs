use Mix.Config

config :kaffe,
  consumer: [
    endpoints: ["harishmag.local": 9092],
    # the topic(s) that will be consumed
    topics: ["server1.dbo.customers", "server1.dbo.products", "server1.dbo.orders"],
    # the consumer group for tracking offsets in Kafka
    consumer_group: "kaffe-consumer-grp21",
    offset_reset_policy: :reset_to_earliest,
    # the module that will process messages
    message_handler: ExampleConsumer
  ]
